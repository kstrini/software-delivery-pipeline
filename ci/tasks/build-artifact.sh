#!/usr/bin/env bash
set -e

export GRADLE_OPTS=-Dorg.gradle.native=false
BINARY_DIR=$PWD/binary

version=`cat version/number`
cd code-repo
gradle assemble -PVersion=$version

mv build/libs/*.war $BINARY_DIR
ls $BINARY_DIR