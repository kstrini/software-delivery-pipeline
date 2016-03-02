#!/usr/bin/env bash
set -e

get_code="curl -I $CODE_URL 2>/dev/null | head -n 1 | cut -d$' ' -f2"
status_code=`eval $get_code`
if [ "$status_code" != "204" ]
then
  echo "Expect status code from $CODE_URL as 204, but got $status_code"
  exit 1
fi