#!/bin/bash
# Generate ICNS file and place into project

SOURCE_FILE=../filecheckicon.svg
ICONS_DIR=src/main/deploy/package/macosx
APP_NAME=FileCheck
INKSCAPE_PATH=/Applications/Inkscape.app/Contents/Resources/bin/inkscape
ICONSET=$APP_NAME.iconset

if [[  $ICONS_DIR/$APP_NAME.icns -nt $SOURCE_FILE ]]; then
    echo Skipping icon generation
    exit 0
fi

mkdir -p $ICONSET
 
$INKSCAPE_PATH --export-png $ICONSET/icon_16x16.png -w 16 -h 16 $SOURCE_FILE
$INKSCAPE_PATH --export-png $ICONSET/icon_16x16@2x.png -w 32 -h 32 $SOURCE_FILE
$INKSCAPE_PATH --export-png $ICONSET/icon_32x32.png -w 32 -h 32 $SOURCE_FILE
$INKSCAPE_PATH --export-png $ICONSET/icon_32x32@2x.png -w 64 -h 64 $SOURCE_FILE
$INKSCAPE_PATH --export-png $ICONSET/icon_128x128.png -w 128 -h 128 $SOURCE_FILE
$INKSCAPE_PATH --export-png $ICONSET/icon_128x128@2x.png -w 256 -h 256 $SOURCE_FILE
$INKSCAPE_PATH --export-png $ICONSET/icon_256x256.png -w 256 -h 256 $SOURCE_FILE
$INKSCAPE_PATH --export-png $ICONSET/icon_256x256@2x.png -w 512 -h 512 $SOURCE_FILE
$INKSCAPE_PATH --export-png $ICONSET/icon_512x512.png -w 512 -h 512 $SOURCE_FILE
$INKSCAPE_PATH --export-png $ICONSET/icon_512x512@2x.png -w 1024 -h 1024 $SOURCE_FILE

iconutil -c icns $ICONSET

rm -rf $ICONSET

mkdir -p $ICONS_DIR

mv $APP_NAME.icns $ICONS_DIR

