plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "cat.institutmontivi.themoviedb"
    compileSdk = 34

    defaultConfig {
        applicationId = "cat.institutmontivi.themoviedb"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Navegació
    implementation("androidx.navigation:navigation-compose:2.7.7")
    //Biblioteca extesa d'icones
    implementation ("androidx.compose.material:material:1.6.1")
    //DataStore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")
    //Lifecycle
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    //Scalar converter de Retrofit
    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")

    //Gson converter de Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


    //Convertidors moshi de retrofit
    implementation ("com.squareup.moshi:moshi:1.11.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")


    //Coil  (Per a carregar imatges d'internet
    implementation ("io.coil-kt:coil-compose:2.5.0")

    //Constraint layout per a Compose
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")

}