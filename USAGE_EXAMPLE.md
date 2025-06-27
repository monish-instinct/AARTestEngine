# 📖 Complete Usage Example

This document provides a comprehensive example of how to integrate and use the SkynetBee Developer Environment Library in your Android project.

## 📱 Complete Sample Implementation

### 1. Project Setup

#### `build.gradle` (Project level)
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

#### `settings.gradle`
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
        maven { url "https://jitpack.io" }
    }
}

rootProject.name = "YourProjectName"
include ':app'
```

#### `app/build.gradle`
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
        minSdk 26
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
}

dependencies {
    // Core AndroidX dependencies
    implementation 'androidx.core:core-ktx:1.16.0'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.9.1'
    implementation 'androidx.activity:activity-compose:1.10.1'
    
    // Compose BOM and UI dependencies
    implementation platform('androidx.compose:compose-bom:2025.06.00')
    implementation 'androidx.compose.ui:ui'
    implementation 'androidx.compose.ui:ui-graphics'
    implementation 'androidx.compose.ui:ui-tooling-preview'
    implementation 'androidx.compose.material3:material3'
    
    // 🚀 SkynetBee Developer Environment Library
    implementation 'com.github.monish-instinct:AARTestEngine:v1.0.0'
    
    // Testing dependencies
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation platform('androidx.compose:compose-bom:2025.06.00')
    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
    debugImplementation 'androidx.compose.ui:ui-tooling'
    debugImplementation 'androidx.compose.ui:ui-test-manifest'
}
```

### 2. AndroidManifest.xml
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

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
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

### 3. MainActivity.kt
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
// These imports will work once the library is properly integrated
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
                    // Test library components here
                    testMessage.value = "Testing library components..."
                    
                    // Example usage:
                    // try {
                    //     // Use Smart Buttons
                    //     SmartButton.create(...)
                    //     
                    //     // Use Smart Tables
                    //     SmartTable.create(...)
                    //     
                    //     // Use Charts
                    //     BarGraph.create(...)
                    //     
                    //     // Use Utilities
                    //     Validator.validateEmail(...)
                    //     
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

## 🚀 Usage Examples

### Using Smart Buttons
```kotlin
// Example of using Smart Button component
SmartButton(
    text = "Click Me",
    onClick = { /* Handle click */ },
    style = SmartButtonStyle.PRIMARY
)
```

### Using Charts
```kotlin
// Example of using Bar Graph
BarGraph(
    data = listOf(10, 20, 30, 40),
    labels = listOf("Q1", "Q2", "Q3", "Q4"),
    colors = listOf(Color.Blue, Color.Green, Color.Orange, Color.Red)
)
```

### Using Database (SQLizer)
```kotlin
// Example of using SQLizer for database operations
val sqlizer = SQLizer(context)
sqlizer.createTable("users", mapOf(
    "id" to "INTEGER PRIMARY KEY",
    "name" to "TEXT",
    "email" to "TEXT"
))
```

### Using Validators
```kotlin
// Example of using built-in validators
val isValidEmail = Validator.validateEmail("user@example.com")
val isValidPhone = Validator.validatePhone("+1234567890")
```

## 🔧 Advanced Configuration

### ProGuard Rules (proguard-rules.pro)
```proguard
# Keep library classes
-keep class skynetbee.developers.developerenvironment.** { *; }

# Keep Gson classes
-keepattributes Signature
-keepattributes *Annotation*
-dontwarn sun.misc.**
-keep class com.google.gson.** { *; }

# Keep OkHttp
-dontwarn okhttp3.**
-keep class okhttp3.** { *; }

# Keep RxJava
-dontwarn io.reactivex.**
-keep class io.reactivex.** { *; }
```

## 📊 Performance Tips

1. **Initialize Early**: Initialize the library in your Application class or MainActivity's onCreate()
2. **Use Lazy Loading**: Load heavy components only when needed
3. **Cache Results**: Cache database queries and API responses
4. **Optimize Images**: Use appropriate image sizes for your UI components

## 🛠️ Troubleshooting

### Build Issues
- Ensure you have the latest Android Gradle Plugin
- Check that all required permissions are in AndroidManifest.xml
- Verify JitPack repository is added to your repositories

### Runtime Issues
- Make sure to initialize the library before using components
- Check that required permissions are granted
- Verify minimum SDK version (26+)

## 📱 Testing Your Integration

1. **Build the project**: `./gradlew build`
2. **Run on device/emulator**: Check that the app launches successfully
3. **Test components**: Use the test button to verify library integration
4. **Check logs**: Monitor for any initialization errors

---

**🎉 You're ready to build amazing Android apps with SkynetBee Developer Environment Library!**
