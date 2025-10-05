# 📡 Android Networking & Data Parsing: A Practical Guide

**Android Networking & Data Parsing: A Practical Guide** is a demonstration Android application developed for a **Computer Science course** at **Mbarara University of Science and Technology (MUST)**.  
It serves as a **hands-on, living lecture** that contrasts foundational Android networking techniques with modern, industry-standard libraries used in contemporary app development.


## 🧭 Overview

This project demonstrates how to **fetch**, **parse**, and **display** data from various internet sources in Android.  
It is designed to provide **clear, working examples** for key concepts covered in the *“Using Internet Resources”* module.

The app implements three core features representing real-world networking scenarios:

1. 🌐 **Live Website Display** – Render a live website directly inside the app using `WebView`.  
2. 🔗 **REST API Consumption** – Fetch and display structured JSON data from a public API using `Retrofit` and `Gson`.  
3. 📰 **HTML Web Scraping** – Extract and display unstructured content (e.g., news articles) using `Jsoup`.


## 🧰 Technologies & Concepts Covered

### 🔗 Core Networking
- **Modern HTTP Client (Retrofit):** Type-safe, declarative library for making REST API calls.  
- **Foundational HTTP Client (HttpURLConnection):** Introduced as a low-level concept for understanding legacy network calls.  
- **Permissions:** Declaring `INTERNET` and `ACCESS_NETWORK_STATE` in `AndroidManifest.xml`.  
- **Network State Management:** Checking connectivity via `ConnectivityManager` and `NetworkInfo`.  

### 📦 Data Parsing
- **JSON Parsing (Gson):** Automatically converts JSON API responses into Java POJOs.  
- **HTML Parsing (Jsoup):** Extracts structured data from live web pages for real-time scraping.  
- **XML Parsing (XmlPullParser):** Covered as a legacy concept for older data feeds.

### ⚙️ Concurrency & Background Tasks
- **Modern Approach:** `ExecutorService` and `Handler` for background processing to avoid UI blocking.  
- **Legacy Approach:** `AsyncTask` demonstrated as a deprecated technique for conceptual understanding.

### 🎨 UI & Views
- **RecyclerView:** Efficiently displays lists of parsed data.  
- **Glide:** Handles image downloading, caching, and rendering from URLs.  
- **WebView:** Displays live web content within an activity.  
- **Material Design Components:** Uses standard UI elements such as `Button`, `ProgressBar`, and `LinearLayout`.

### 🧠 Best Practices
- **Battery Efficiency:** Illustrates batching and throttling of network requests.  
- **Separation of Concerns:** Demonstrates modular architecture with dedicated classes for models, adapters, and network clients.

## 🛠️ Getting Started

### 📋 Dependencies
Ensure the following tools are installed before running the project:
- **Android Studio** (Bumblebee | 2021.1.1 or newer)  
- **Java Development Kit (JDK 11 or newer)**  
- **Android SDK API Level 24 or higher**  
- **Stable Internet Connection**

### 💾 Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/your-repository-name.git
   ```

2. **Open in Android Studio**
   - Launch **Android Studio**
   - Select **File → Open**
   - Navigate to the cloned project folder

3. **Sync Gradle**
   - Allow Gradle to download and configure all dependencies automatically.


### ▶️ Running the Application

1. Connect a physical Android device via **USB** or start an **Android Virtual Device (AVD)**.  
2. Ensure the device has an **active internet connection**.  
3. Click **Run (▶)** in Android Studio to build and install the application.  
4. Explore the three main features:
   - WebView website rendering  
   - REST API data retrieval  
   - HTML scraping and display  


## 🌐 Data Sources

The following **public data sources** are used for demonstration purposes:

| Source | Description |
|--------|--------------|
| [Mbarara University of Science and Technology (MUST)](https://must.ac.ug) | Official website and news portal |
| [JSONPlaceholder](https://jsonplaceholder.typicode.com/) | Public REST API for JSON data |
| [ChimpReports](https://chimpreports.com/) | Public news website for HTML parsing examples |


## 📜 License

This project is licensed under the **MIT License** – see the [LICENSE.md](LICENSE.md) file for details.


## 👨‍🏫 Author

**Dr. Richard Kimera (PhD)**  
Lecturer – Faculty of Computing and Informatics  
[Mbarara University of Science and Technology (MUST)](https://must.ac.ug)


## 🌟 Educational Purpose

> This project was developed as a **pedagogical resource** to help students at Mbarara University of Science and Technology gain a practical understanding of Android networking, concurrency, and data parsing through real-world examples.


📘 *README inspired by [awesome-readme](https://github.com/matiassingers/awesome-readme) and [PurpleBooth](https://github.com/PurpleBooth).*
