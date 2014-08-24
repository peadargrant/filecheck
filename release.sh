#!/bin/bash
# Release setup

# Determine the current version from the tags

CURRENT_VERSION=`git tag | xargs -I@ git log --format=format:"%ai @%n" -1 @ | sort | awk '{print $4}' | grep v- | tail -1`
echo current version tag: $CURRENT_VERSION


# Decompose the version number
VERSION=`echo $CURRENT_VERSION | awk -F"-" '{print $2}'`
echo current version: $VERSION
MAJOR=`echo $VERSION | awk -F"." '{print $1}'`
echo major: $MAJOR
MINOR=`echo $VERSION | awk -F"." '{print $2}'`
echo minor: $MINOR
REV=`echo $VERSION | awk -F"." '{print $3}'`
if [ -z "$REV" ];then
    REV="0"
fi
echo revision: $REV


# Count the number of important "events" from the commit logs

LOG_QUERY_COMMAND="git log $CURRENT_VERSION..HEAD --oneline"

MAJOR_COUNT=`$LOG_QUERY_COMMAND | grep "\[major\]" | wc -l`
echo $MAJOR_COUNT major changes

FEATURE_COUNT=`$LOG_QUERY_COMMAND | grep "\[feature\]" | wc -l`
echo $FEATURE_COUNT features

FIX_COUNT=`$LOG_QUERY_COMMAND | grep "\[fix\]" | wc -l`
echo $FIX_COUNT fixes


# Determine what type of release this is and do the increment

if [ "$MAJOR_COUNT" -gt 0 ];then
   echo major version increment
   (( MAJOR += 1 ))
elif [ "$FEATURE_COUNT" -gt 0 ]
then
   echo minor version increment
   (( MINOR += 1 ))
else
   echo hotfix version increment
   (( REV += 1 ))
fi


# Leave off the final part if it's zero

FINAL_SEP="."
if [ "$REV" -eq 0 ];then
    REV=""
    FINAL_SEP=""
fi


# Assemble the new version number

NEW_VERSION=$MAJOR.$MINOR$FINAL_SEP$REV
echo new version: $NEW_VERSION


# Bail out if the command given is not modify

if [ "$1" == "modify" ]; then
    echo "modifying version"
else
    echo "test mode - no modification made" 
    exit
fi


# Check that the staging area is clean

git diff --cached --exit-code > /dev/null
STAGING_STATUS=$?
echo "staging area status code: $STAGING_STATUS"
if [ "$STAGING_STATUS" -eq 0 ]; then
    echo "staging area is clean"
else
    echo "staging area has files that are not committed" 
    exit
fi


# Modify in Maven

if [ -f "pom.xml" ]; then
    mvn versions:set -DnewVersion=$NEW_VERSION
    mvn versions:commit
    git add '*pom.xml'
fi

git commit -m "released version v-$NEW_VERSION: $2"

git tag -a "v-$NEW_VERSION" -m "v-$NEW_VERSION: $2"

echo "new version committed - rememeber to re-build artifacts before public release!!!"
