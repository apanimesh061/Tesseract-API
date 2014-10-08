#!/bin/sh
set -e

current_dir=$(dirname $0)
echo "Running autobuild"
cd "$current_dir"

if [ -e $BUILD ]
then
  echo "Skipping C++ build as the build directory already exists"
  exit
fi

mkdir $BUILD

echo "building leptonica"
cd leptonica-1.71
./configure --prefix=$BUILD --with-pic --disable-shared --enable-shared=no --disable-programs --without-zlib --without-libpng --without-jpeg --without-giflib --without-libtiff --without-libwebp --without-libopenjpeg
make install
cd ..

echo "building tesseract"
cd tesseract-3.03
export CPPFLAGS="-I$BUILD/include"
export LIBLEPT_HEADERSDIR="$BUILD/include"
./configure --prefix=$BUILD --with-extra-libraries=$BUILD/lib --with-pic --enable-shared=no --disable-graphics 
make install
cd ..

echo "Auto-building all libraries finished"
