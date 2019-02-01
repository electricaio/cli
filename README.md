# CLI
Allow to simplify Lambda development and Pipeline building.

## Assemble
Use Gradle to assemble archive:
```bash
./gradlew clean assemble
```
Then you can find archive in `build/distributions` folder.

## Run
- extract archive;
- start script from `bin` folder

## Man
You can use `electrica --help` to find full actual documentation.
```bash
Usage: electrica [options] [command] [command options]
  Options:
    -d, --debug
      Enable debug output.
      Default: false
    -h, --help
      Show help description.
    -v, --version
      Show application version.
```

## Commands 

### Generate pipeline template for Java 8
Command allow you to create pipeline project skeleton for Java 8 language.
Please use `electrica generate-java8 --help` to find actual command documentation.

```bash
Generate lambda skeleton project for Java 8.
Usage: generate-java8 [options]
  Options:
    -a, --artifact
      Maven artifact for generated project.
      Default: example-pipeline
    -g, --group
      Maven group for generated project.
      Default: com.example
    -h, --help
      Show command help.
    -o, --out
      Generation output directory.
      Default: ./
    -v, --version
      Maven version for generated project.
      Default: 0.0.1-SNAPSHOT
```
After this you can open project in your IDE and start develop your own lambdas.

### Build Pipeline Launcher Archive
Command allow you to build complete pipeline launcher archive for specified lambda jars and dependencies.
Please use `electrica build-launcher --help` to find actual command documentation.

```bash
Build complete pipeline launcher archive for specified lambdas.
Usage: build-launcher [options]
  Options:
    -h, --help
      Show command help.
    -jar, --lambda-jar
      Paths to lambda jars to be included in pipeline launcher. Option can be 
      set few times.
      Default: []
    -dir, --lambda-jar-dirs
      Paths to lambda jar directories to be included in pipeline launcher. 
      Will include all files, that ends with `.jar`. Option can be set few 
      times. 
      Default: []
    -o, --out
      Result pipeline launcher archive path.
      Default: ./pipeline-launcher.zip
  * -l, --raw-launcher
      Path to raw pipeline launcher archive.
```
After build you can use pipeline launcher to start lambdas.
To read manual:
```bash
./electrica-pipeline-java8-launcher --key <access_key> --url https://api.stage.electrica.io --start BrassringToHackerrank --start HackerrankToBrassring
```
See Pipeline Launcher documentation below for more details.

### Build Pipeline Docker Image
Command allow you to build Docker image from pipeline launcher archive.
Please use `electrica build-docker --help` to find actual command documentation.

```bash
Build docker image for specified pipeline launcher.
Usage: build-docker [options]
  Options:
    -h, --help
      Show command help.
    -l, --launcher
      Pipeline launcher archive path.
      Default: ./pipeline-launcher.zip
    -t, --tag
      Docker image build tag.
      Default: electrica/pipeline:latest
```
After build you can use pipeline launcher inside Docker container.
To read manual:
```bash
docker run electrica/pipeline --help
```
To start lambdas:
```bash
docker run electrica/pipeline --key <access_key> --url https://api.stage.electrica.io --start BrassringToHackerrank --start HackerrankToBrassring 
```
