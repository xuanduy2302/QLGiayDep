@echo off
setlocal

REM === Định dạng ngày an toàn ===
for /f %%a in ('wmic os get LocalDateTime ^| find "."') do set datetime=%%a
set DATESTAMP=%datetime:~0,4%-%datetime:~4,2%-%datetime:~6,2%

REM === Đường dẫn gốc của project ===
set "PROJECT_DIR=C:\Users\xuand\OneDrive\Desktop\QLGiayDep\QuanLyBanGiayDep"
set "BACKUP_DIR=%PROJECT_DIR%\backup"
set "TODAY_BACKUP=%BACKUP_DIR%\backup_%DATESTAMP%"

REM === Tạo thư mục backup nếu chưa tồn tại ===
if not exist "%BACKUP_DIR%" mkdir "%BACKUP_DIR%"
mkdir "%TODAY_BACKUP%"

REM === Tạo file exclude để bỏ qua thư mục backup khi sao chép mã nguồn ===
set "EXCLUDE_FILE=%PROJECT_DIR%\backup\exclude_backup.txt"
echo \backup\ > "%EXCLUDE_FILE%"

REM === Xóa các thư mục sao lưu cũ hơn 7 ngày ===
forfiles /p "%BACKUP_DIR%" /m "backup_*" /D -7 /C "cmd /c rd /s /q @path"

echo 🔄 Đang backup CSDL qlst...

REM === Backup database (nếu XAMPP đang chạy mysql) ===
C:\xampp\mysql\bin\mysqldump.exe -u root --port=3307 --databases qlst > "%TODAY_BACKUP%\qlst.sql"

if %ERRORLEVEL% NEQ 0 (
    echo ❌ Lỗi khi backup CSDL!
) else (
    echo ✅ Backup CSDL thành công!
)

REM === Ghi log ===
echo Backup hoàn tất vào %DATE% %TIME% > "%TODAY_BACKUP%\log.txt"
echo 🟢 Sao lưu hoàn tất tại: %TODAY_BACKUP%

pause
