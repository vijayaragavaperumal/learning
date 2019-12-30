cd ..
call start cmd /c "call java -jar -Dspring.profiles.active=dev -Dspring.cloud.zookeeper.enabled=false -Dspring.cloud.zookeeper.config.watcher.enabled=false target\hellocamel-8.6.0-SNAPSHOT-embedded.jar -Dcamel.trace.enabled=true"
timeout 30
call start cmd /c "start chrome "http://localhost:8090/orchestrationservices/swagger-ui.html#""
:: netstat -ano | findstr :11099
:: taskkill /PID 13900 /F
