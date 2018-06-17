@echo off
@echo off

set OLSYSTEM_PATH=OLSystem
set PROGCHECKER_PATH=ProgChecker
set DATABASE_PATH=Database
set GUI_ADMIN_ROOM_PATH=%OLSYSTEM_PATH%\src\main\webapp\admin-room-page

set BUILD_DIRECTORY_OLSYSTEM=%OLSYSTEM_PATH%\target
set BUILD_DIRECTORY_PROGCHECKER=%ProgChecker%\build
set BUILD_JS_FILE_FOR_ADMIN_ROOM=%GUI_ADMIN_ROOM_PATH%\build\bundle.js
	
if not exist %BUILD_DIRECTORY_OLSYSTEM% (
	echo Building OLSystem...
	cd %OLSYSTEM_PATH%
	mvn install
	cd ..
) else (
	echo OLSystem is already built.
)

if not exist %BUILD_DIRECTORY_PROGCHECKER% (
	echo Building ProgChecker...
	cd %PROGCHECKER_PATH%
	mkdir build
	cd build
	cmake ..
	cd ..
	cd ..
) else (
	echo ProgChecker is already built.
)

echo Import database...
cd %DATABASE_PATH%
mysql -u root -padmin OLSystem < database.sql
cd ..

if not exist %BUILD_JS_FILE_FOR_ADMIN_ROOM%(
	echo Building JS file for administrator room...
	cd %GUI_ADMIN_ROOM_PATH%\build
	npm i
	npm run build
) else (
	echo JS file for administrator room is built.
)

pause