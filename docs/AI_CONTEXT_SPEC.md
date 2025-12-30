# AI Context Injection Specification

## Overview
The AI Coach feature will be "Context-Aware". This means it won't just answer generic questions; it will know the user's current workload and blocking status to provide tailored advice.

## Data Flow
1.  **User opens Chat:** App retrieves active tasks from `Room Database`.
2.  **Context Construction:** App formats tasks into a lightweight text summary.
3.  **API Request:** App sends `System Prompt` + `Task Context` + `User Query` to Gemini API.
4.  **Response:** Gemini generates advice based on the specific tasks.

## Prompt Engineering Design

### System Prompt Template
```text
You are FocusCoach, an expert productivity assistant embedded in an Android app.
Your goal is to help the user complete their tasks and stay focused.

CURRENT CONTEXT:
[
  { "id": 1, "title": "Finish Math Homework", "status": "PENDING", "priority": "HIGH" },
  { "id": 2, "title": "Read 10 pages", "status": "PENDING", "priority": "LOW" }
]

INSTRUCTIONS:
- Refer to the user's specific tasks when possible.
- If the user has High Priority tasks pending, encourage them to start there.
- Keep answers short (under 3 sentences) as they are reading on a mobile phone.
```

## Privacy Constraints
- **Only** Task Titles, Priorities, and Status are sent.
- **Never** send personal identifiers or sensitive content from notes.
- Context is ephemeral (sent per request), not stored on the server side (unless using history-aware endpoints).
