#!/usr/bin/env bash
set -x

target="cf api $API_ENDPOINT --skip-ssl-validation"
echo $target
eval $target

echo "Login....."
login="cf auth $USERNAME $PASSWORD"
echo $login
eval $login

echo "Target Org and Space"
org_space="cf target -o $ORG -s $SPACE"
eval $org_space

echo "push the app - no start"
push="cf push $HOST -n $HOST -p code-release/simple-mongodb-rest-app-*.war -m 1GB"
echo $push
eval $push

echo "bind the app"
bindsvc="cf bind-service $HOST p-mongodb"
echo $bindsvc
eval $bindsvc