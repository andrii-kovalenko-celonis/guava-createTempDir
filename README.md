# guava-createTempDir

Try to reproduce https://github.com/google/guava/issues/6535 on Windows with `guava:32.1.2` (see [the comment](https://github.com/google/guava/issues/6535#issuecomment-1741201254))

```bash
$ ./gradlew clean build shadowJar
$ java -jar build/libs/guava-createTempDir-1.0-SNAPSHOT-all.jar

createdTempDir is located at "C:\Users\XXX~1\AppData\Local\Temp\18\3566282287860420796"
Content: test.file
```
(this is correct behavior, no exception)
