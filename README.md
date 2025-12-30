# Android Focus Planner & Blocker

## Project Overview
This project aims to build a **Hybrid** Android application focused on productivity and digital well-being. It combines a personal planner, a robust app blocker, and an **AI-powered productivity coach**.

### Target Device
- **Device:** Infinix Note 30 Pro
- **OS:** Android 14
- **Key Requirement:** Optimization for XOS battery management and permissions.

### Core Features
1.  **Planner & Tracker:** 
    -   Daily planning and task management.
    -   **Progress Logging:** Gamified system to track achievements and streaks (Local Database).
2.  **App Blocker:** 
    -   **Technology:** Uses `AccessibilityService` to detect and block apps.
    -   **Focus Mode:** Prevents distractions during planned sessions.
3.  **AI Coach (New):**
    -   Integrated Chatbot assistant for advice and motivation.
    -   **Connectivity:** Requires Internet for AI API calls (Gemini/OpenAI), but Planner/Blocker remain functional offline.

## Methodology
We are following an AI-assisted development flow:
1.  **Research & Requirements:** Defining core features based on productivity science.
2.  **Design (Stitch):** Creating the UI/UX for the planner, blocker, and chat interface.
3.  **Prototyping:** Validating the flow.
4.  **Development (Android Studio):** 
    -   Kotlin/Jetpack Compose.
    -   Room Database for local data (Tasks, Logs).
    -   Retrofit/Ktor for AI API integration.
5.  **Optimization:** Tuning for Infinix XOS to prevent background service killing.

## Getting Started
*Work in progress. Check the [Issues](https://github.com/InfinixCox/android-focus-planner/issues) tab for the roadmap.*
