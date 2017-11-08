 # DoubleDatePicker
 
 **1.Import** 
 
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
 		compile 'com.github.wufengfeilong:MyLib:1.4'
 	}
 ```
 **2.Usage**
 
 Step 1.Add DoubleDatePicker to your layout xml file.
  ```
 <lohas.ddp.DoubleDatePicker
             android:id="@+id/ddp"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"/>
 ```
  Step 2.Declare DoubleDatePicker and Relation it.
   ```
  DoubleDatePicker ddp;
  ```
  ```
  ddp = (DoubleDatePicker) findViewById(R.id.ddp);
  ```
 **3.Provided Method**
 
 `getStartDate()`: get start date
 
 `getEndDate()`: get end date