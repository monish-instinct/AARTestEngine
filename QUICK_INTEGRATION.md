# 🚀 Quick Integration Guide

This guide will help you integrate the SkynetBee Developer Environment Library into a new or existing Android project in **5 minutes**.

## 📱 Option 1: Clone Working Sample Project

```bash
# Clone a complete working sample project
git clone https://github.com/monish-instinct/AARTestEngine.git
cd AARTestEngine

# Check out the sample project in the 'sample' directory
# (This would be a separate branch with a complete sample app)
```

## 🛠️ Option 2: Manual Integration

### Step 1: Project Setup

#### Update your `build.gradle` (Project level):
```gradle
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:8.2.2'
        classpath 'org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.25'
    }
}
```

#### Update your `settings.gradle`:
```gradle
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven { url "https://jitpack.io" }  // 👈 Add this line
    }
}

rootProject.name = "YourProjectName"
include ':app'
```

### Step 2: App Module Setup

#### Update your `app/build.gradle`:
```gradle
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

android {
    namespace 'com.yourcompany.yourapp'
    compileSdk 34

    defaultConfig {
        applicationId "com.yourcompany.yourapp"
        minSdk 26  // 👈 Important: Min SDK 26
        targetSdk 34
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_11
        targetCompatibility JavaVersion.VERSION_11
    }
    
    kotlinOptions {
        jvmTarget = '11'
    }
    
    buildFeatures {
        compose true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion '1.5.15'
    }
    
    packaging {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }
    
    lint {
        checkReleaseBuilds false
        abortOnError false
    }
}

dependencies {
    // Core AndroidX dependencies - compatible versions
    implementation 'androidx.core:core-ktx:1.13.1'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.8.6'
    implementation 'androidx.activity:activity-compose:1.9.2'
    
    // Compose BOM and UI dependencies - compatible versions
    implementation platform('androidx.compose:compose-bom:2024.09.03')
    implementation 'androidx.compose.ui:ui'
    implementation 'androidx.compose.ui:ui-graphics'
    implementation 'androidx.compose.ui:ui-tooling-preview'
    implementation 'androidx.compose.material3:material3'
    
    // 🚀 SkynetBee Developer Environment Library
    implementation 'com.github.monish-instinct:AARTestEngine:v1.0.1'
    
    // Testing dependencies
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation platform('androidx.compose:compose-bom:2024.09.03')
    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
    debugImplementation 'androidx.compose.ui:ui-tooling'
    debugImplementation 'androidx.compose.ui:ui-test-manifest'
}
```

### Step 3: AndroidManifest.xml

#### Add required permissions:
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <!-- Network permissions -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    <!-- Storage permissions -->
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

    <!-- Camera and media permissions -->
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.RECORD_AUDIO" />

    <!-- Phone permissions (if using phone features) -->
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    
    <!-- Hardware features -->
    <uses-feature android:name="android.hardware.camera" android:required="false" />
    <uses-feature android:name="android.hardware.microphone" android:required="false" />
    <uses-feature android:name="android.hardware.telephony" android:required="false" />

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/Theme.YourApp"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:label="@string/app_name"
            android:theme="@style/Theme.YourApp">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

### Step 4: Create MainActivity

#### Create `MainActivity.kt`:
```kotlin
package com.yourcompany.yourapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yourcompany.yourapp.ui.theme.YourAppTheme

// Import your AAR library components
// import skynetbee.developers.developerenvironment.DeveloperFramework.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        // Initialize the library
        // EngineStarter.initialize(this)
        
        setContent {
            YourAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val testMessage = remember { mutableStateOf("Library loaded successfully!") }
    
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SkynetBee Developer Environment",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            
            Text(
                text = testMessage.value,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            Button(
                onClick = {
                    testMessage.value = "Testing library components..."
                    
                    // Test library components here
                    // Example:
                    // try {
                    //     // Use library functionality
                    //     testMessage.value = "All components working perfectly!"
                    // } catch (e: Exception) {
                    //     testMessage.value = "Error: ${e.message}"
                    // }
                }
            ) {
                Text("Test Library Components")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    YourAppTheme {
        MainScreen()
    }
}
```

## 🔧 Step 5: Build and Test

1. **Sync Project**: Click "Sync Now" in Android Studio
2. **Build Project**: Run `./gradlew build` or build from Android Studio
3. **Run App**: Deploy to device/emulator

## ✅ Verification Checklist

- [ ] JitPack repository added to `settings.gradle`
- [ ] Library dependency added to `app/build.gradle`
- [ ] All required permissions in `AndroidManifest.xml`
- [ ] Min SDK set to 26 or higher
- [ ] Compile SDK set to 34
- [ ] Android Gradle Plugin version 8.2.2
- [ ] Project builds successfully
- [ ] App runs without crashes

## 🚨 Troubleshooting

### Build Fails with "Could not resolve dependency"
- **Solution**: Wait 5-10 minutes for JitPack to process the library
- **Alternative**: Check that `maven { url "https://jitpack.io" }` is correctly added

### Manifest Merger Failed
- **Solution**: Ensure all permissions and features are correctly added
- **Check**: Compare your manifest with the example above

### Compilation Errors
- **Solution**: Use the exact dependency versions shown in this guide
- **Check**: Ensure Android Gradle Plugin is 8.2.2

## 📞 Need Help?

1. Double-check all steps above
2. Compare your setup with the `USAGE_EXAMPLE.md` file
3. Ensure you're using compatible dependency versions

---

**🎉 You're ready to start building with SkynetBee Developer Environment Library!**
