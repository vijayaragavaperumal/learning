cd ..
call start cmd /c "call java -javaagent:tools\libs\jolokia-jvm-1.6.0-agent.jar=port=8778,host=localhost -jar -Dspring.profiles.active=dev -Dspring.cloud.zookeeper.enabled=false -Dspring.cloud.zookeeper.config.watcher.enabled=false target\orchestration-8.1.0-SNAPSHOT-exec.jar -Dcamel.trace.enable=true"
timeout 30
call start cmd /c "start chrome "http://localhost:8090/ecomm/swagger-ui.html#""
:: netstat -ano | findstr :11099
:: taskkill /PID 13900 /F
