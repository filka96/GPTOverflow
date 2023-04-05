# GPTOverflow

## preparing
- java 17+

## build
./graldew clean build

## run
java -jar api/build/libs/api.jar ${chatGpt-token} ${request}

#### chatGpt-token you can find here
https://platform.openai.com/account/api-keys

#### example:

java -jar api/build/libs/api.jar foo-token how to be cool?
