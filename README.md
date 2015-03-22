# MyGcm
api_key=AIzaSyBHnKJMyksfjTdYtiTpEne46REBL3YLV3k
reg_id=APA91bEsHeMqhzlzF-e-N4sj3t9XaWpjwBIK9idnudL0ou91mCcjpskQ5i13wjHIXuTGFtAdtc3VdI_xAYzlW5E-DOtj9Avitbsq6jefoQOzqLNAWiyZGtHqmcSyg09bOE0SaDvFJXLN1_R7ovu8vibitfUIWPftQQ

curl --header "Authorization: key=$api_key" --header Content-Type:"application/json" https://android.googleapis.com/gcm/send  -d "{\"registration_ids\":[\"$reg_id\"]}"
