 #DoubleDatePicker
 Import 
 
 Step 1. Add the JitPack repository to your build file.
 
 Add it in your **root** build.gradle at the end of repositories:
 
 ```
 allprojects {
     repositories {
         jcenter()
         maven { url 'https://jitpack.io' }
     }
 }
 ```
 Step 2. Add the dependency
 
 Add it in your **module** build.gradle at the end of dependencies:
 ```
 dependencies {
 		compile 'com.github.wufengfeilong:MyLib:1.2'
 	}
 ```