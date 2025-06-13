git push && ^
ng build && ^
cd springapp && ^
mvnw clean package -Dmaven.test.skip=true && ^
docker build -t javierlete/springapp . && ^
docker push javierlete/springapp && ^
curl https://api.render.com/deploy/srv-d14id663jp1c73betsfg?key=RwTQNFbAw80 && ^
cd .. 
