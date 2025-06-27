# SkynetBee Developer Environment Library

🚀 **A comprehensive Android development library** that provides powerful tools and UI components for Android developers.

## 📦 Easy Integration via Gradle

### Step 1: Add JitPack Repository

Add this to your **project-level** `build.gradle` (or `settings.gradle` for newer projects):

```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add Dependency

Add this to your **app-level** `build.gradle`:

```gradle
dependencies {
    implementation 'com.github.monish-instinct:AARTestEngine:v1.0.0'
}
```

### Step 3: Sync Project

Click "Sync Now" in Android Studio.

## 🛠️ Setup Requirements

### Minimum Requirements
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 35
- **Compile SDK**: 36
- **Java Version**: 11
- **Kotlin**: 1.9.20+
- **AndroidX**: Required

### Dependencies
The library includes the following dependencies:
- AndroidX Core KTX
- AndroidX Lifecycle
- AndroidX AppCompat
- Jetpack Compose
- Material Design 3
- OkHttp
- Gson
- RxJava
- Lottie Animations
- And many more...

## 📋 Required Permissions

Add these permissions to your `AndroidManifest.xml`:

```xml
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
```

## 🎯 Quick Start

Once integrated, you can start using the library components:

```kotlin
import skynetbee.developers.developerenvironment.DeveloperFramework.*

// Example usage in your Activity/Fragment
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize the library
        EngineStarter.initialize(this)
        
        // Use library components
        setContent {
            // Your compose content with library components
        }
    }
}
```

## 📚 What's Included

This library provides:

### 🎨 UI Components
- **Smart Buttons** - Enhanced button components
- **Smart Tables** - Advanced table views
- **Background Cards** - Beautiful card layouts
- **Rating Stars** - Interactive rating components
- **File Uploaders** - Audio, Video, Image upload components
- **Balloon Slider** - Interactive slider components
- **Pagination** - Smart pagination controls
- **Checkboxes** - Enhanced checkbox components

### 📊 Charts & Graphs
- **Bar Graphs**
- **Line Graphs** (1-5 lines)
- **Doughnut Charts**
- **Multi-line Graphs**

### 🔔 Alerts & Notifications
- **Smart Alerts**
- **Smart Confirm Dialogs**
- **Smart Prompts**
- **Notification Sender**

### 🗄️ Data Management
- **SQLizer** - Database operations
- **Excel Generator** - Excel file creation
- **PDF Generator** - PDF document creation
- **Import/Export** utilities

### 🔧 Utilities
- **Validators** - Input validation
- **Randomizers** - Random data generation
- **User Info** - Device and user information
- **Quick Access** - Common operations
- **Language Replicas** - Multi-language support

## 🔐 Security & Privacy

- Source code is kept private
- Only the compiled AAR is distributed
- Secure database connections
- Device fingerprinting capabilities

## 🏗️ ProGuard

If you're using ProGuard, you may need to add these rules:

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
```

## 🐛 Troubleshooting

### Common Issues

**Issue**: `Unable to resolve dependency`
**Solution**: Make sure JitPack repository is added to your repositories list.

**Issue**: `Manifest merger failed`
**Solution**: Add required permissions to your AndroidManifest.xml

**Issue**: `Compilation errors`
**Solution**: Ensure you're using the correct SDK versions and AndroidX.

## 📞 Support

For issues and questions:
- Check the troubleshooting section above
- Ensure all setup requirements are met
- Verify that all required permissions are added

## 📈 Version History

- **v1.0.0** - Initial release with core components

---

**Made with ❤️ by SkynetBee Developers**

