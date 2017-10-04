# directorychooser
Add it in your root build.gradle at the end of repositories:

//add this to application build.gradle

 repositories {
        mavenCentral()
        maven { url 'http://guardian.github.com/maven/repo-releases' }
    }
	//add this to project build.gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.AvneeshGupta1:directorychooser:-SNAPSHOT'
	}
