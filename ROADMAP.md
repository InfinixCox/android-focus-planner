# Focus Planner AI - Roadmap Completo

**Estado General del Proyecto:** 15% completo (Investigación + Infraestructura Base)

---

## 📊 Fase 0: COMPLETADA ✅ (Lo que ya hicimos)

### Investigación y Documentación
- [x] Especificación de Producto (PRD) generada por NotebookLM
- [x] Documento de Contexto AI (`docs/AI_CONTEXT_SPEC.md`)
- [x] Definición de requisitos técnicos
- [x] Análisis de restricciones de XOS (Infinix Note 30 Pro)

### Infraestructura en GitHub
- [x] Repositorio creado: `android-focus-planner`
- [x] README.md con descripción del proyecto
- [x] Issues (Roadmap) creados y categorizados
- [x] Estructura de carpetas Android estándar iniciada

### Base de Datos (Backend Local)
- [x] `TaskEntity` - Entidad para tareas con flag `is_sensitive`
- [x] `HabitEntity` - Apps a bloquear
- [x] `HabitLogEntity` - Registro de completados (para streaks)
- [x] `AchievementLogEntity` - Logros y gamificación
- [x] `TaskDao` - Data Access Object básico
- [x] `FocusDatabase` - Configuración Room
- [x] `build.gradle.kts` - Dependencias de Room y KSP agregadas

---

## 🎯 Fase 1: INMEDIATA (Hoy/Mañana) - Antes de instalar Android Studio

**Objetivo:** Validación de requisitos previos y setup de herramientas.

### Paso 1.1: Instalación de Herramientas
- [ ] Descargar e instalar **Android Studio** (últimas versión)
  - *Tiempo estimado:* 20-30 minutos (incluye descargas)
- [ ] Descargar **Android SDK 34** (automático durante instalación)
- [ ] Crear un **Android Virtual Device** (Emulador) opcional para testing

### Paso 1.2: Preparar tu Infinix Note 30 Pro
- [ ] Activar **Opciones de Desarrollador** (tocar 7 veces en "Número de compilación")
- [ ] Activar **Depuración por USB**
- [ ] Conectar el cable USB a la PC
- [ ] Autorizar permiso de depuración en el dispositivo

### Paso 1.3: Configuración Local
- [ ] Clonar el repositorio: `git clone https://github.com/InfinixCox/android-focus-planner.git`
- [ ] Abrir proyecto en Android Studio
- [ ] Esperar a que **Gradle Sync** termine
- [ ] Compilar proyecto (`Build > Make Project`)

**Entregable esperado:** App compilada sin errores, lista para instalar en el Infinix.

---

## 📱 Fase 2: FRONTEND BÁSICO (Esta semana) - 25% Proyecto

**Objetivo:** Ver algo en la pantalla. Interfaces visuales funcionales.

### Paso 2.1: Pantalla Principal (Home Screen)
- [ ] Crear `HomeScreen.kt` (Jetpack Compose)
- [ ] Mostrar lista de tareas pendientes
- [ ] Botón para agregar nueva tarea
- [ ] Botón para marcar tarea como completada
- [ ] Navegación básica entre pantallas

### Paso 2.2: Pantalla de Tareas (CRUD)
- [ ] Crear `TaskDetailScreen.kt`
- [ ] Formulario para crear nueva tarea (Título, Descripción, Prioridad, Flag Sensible)
- [ ] Integración con TaskDao para guardar en base de datos
- [ ] Validación de entrada

### Paso 2.3: Dashboard de Progreso
- [ ] Crear `ProgressScreen.kt`
- [ ] Mostrar Contador de Racha (Streaks)
- [ ] Gráfico Canvas simple de tareas completadas hoy/esta semana
- [ ] Mostrar puntos totales

**Entregable esperado:** App funcional que permite crear tareas, verlas listadas, marcarlas como hechas. Datos persisten en el teléfono.

---

## 🤖 Fase 3: AI COACH INTEGRATION (Semana 2) - 40% Proyecto

**Objetivo:** Conectar la IA (Gemini Flash) y hacer que entienda tus tareas.

### Paso 3.1: Configuración de Gemini API
- [ ] Crear cuenta en [Google AI Studio](https://aistudio.google.com)
- [ ] Generar API Key gratuita
- [ ] Agregar `local.properties` (NO subir a GitHub) con la clave
- [ ] Crear `secrets.properties` para manejar secretos

### Paso 3.2: Inyección de Contexto (Prompt Manager)
- [ ] Crear `PromptManager.kt` (Domain layer)
- [ ] Función `buildSystemPrompt(tasks: List<Task>)` que:
  - Lee tareas NO sensibles
  - Formatea JSON con título, prioridad, estado
  - Incluye el template del "Coach" (personalidad, tono, restricciones)
- [ ] Función `sanitizeTaskForAI()` que filtra campos `is_sensitive`

### Paso 3.3: Cliente Gemini
- [ ] Agregar dependencia: `google-generative-ai` SDK para Android
- [ ] Crear `GeminiCoachService.kt`
- [ ] Implementar método `askCoach(userQuery: String, contextTasks: List<Task>): String`
- [ ] Manejo de errores y timeout

### Paso 3.4: Pantalla de Chat
- [ ] Crear `ChatScreen.kt`
- [ ] Input field para preguntas del usuario
- [ ] Mostrar respuestas del Coach con animación
- [ ] Historial de chat básico

**Entregable esperado:** Puedes escribir preguntas y la IA responde sabiendo cuáles son tus tareas pendientes.

---

## 🚫 Fase 4: ACCESSIBILITY SERVICE & BLOCKER (Semana 3) - 70% Proyecto

**Objetivo:** El núcleo del proyecto. Detectar apps y bloquearlas.

### Paso 4.1: AccessibilityService Completo
- [ ] Mejorar `FocusAccessibilityService.kt`
- [ ] Implementar lógica: detectar `packageName` en primer plano
- [ ] Crear lista de apps a bloquear desde BD
- [ ] Validar si está en "Modo de Enfoque" activado

### Paso 4.2: Pantalla de Bloqueo (Overlay)
- [ ] Crear `BlockingOverlay.kt` (Jetpack Compose + WindowManager)
- [ ] Mostrar frases motivacionales categorizadas (Autonomía, Crecimiento, Mindfulness, Resiliencia)
- [ ] Botón "Volver" para regresar a la app anterior
- [ ] Animaciones suaves

### Paso 4.3: Pantalla de Configuración de Bloqueo
- [ ] Crear `BlockerSettingsScreen.kt`
- [ ] Selector de apps a bloquear (con lista de apps instaladas)
- [ ] Toggle "Modo de Enfoque Activo"
- [ ] Horarios de enfoque (Ej: 9 AM - 12 PM)
- [ ] Persistencia en BD

### Paso 4.4: Optimización XOS
- [ ] Crear `XOSOptimizationHelper.kt`
- [ ] Detección automática de Infinix XOS
- [ ] Onboarding con instrucciones para:
  - Desactivar batería restringida
  - Habilitar auto-inicio
  - Bloquear app en recientes

**Entregable esperado:** Cuando intentes abrir Instagram en horario de enfoque, aparece una pantalla motivacional y no accedes. La app sigue corriendo en background.

---

## 🎮 Fase 5: GAMIFICACIÓN & STREAKS (Semana 4) - 85% Proyecto

**Objetivo:** Sistema de recompensas para mantener la motivación.

### Paso 5.1: Motor de Rachas (Streaks)
- [ ] Implementar algoritmo "Row Number Gap" en SQL
- [ ] Crear función `calculateCurrentStreak(): Int`
- [ ] Lograr guardar racha en BD
- [ ] Mostrar en UI con animación confetti

### Paso 5.2: Sistema de Puntos
- [ ] Crear tabla de `Points`
- [ ] +10 puntos por tarea completada
- [ ] +50 puntos por racha de 7 días
- [ ] +200 puntos por racha de 30 días

### Paso 5.3: Pantalla de Logros
- [ ] Crear `AchievementsScreen.kt`
- [ ] Mostrar logros desbloqueados (Badges)
- [ ] Progresos hacia el siguiente logro
- [ ] Historial completo de logros

**Entregable esperado:** Sistema completo de motivación visual. Usuario ve sus racha de días, puntos, e insignias ganadas.

---

## 🧪 Fase 6: TESTING & OPTIMIZACIÓN (Semana 5) - 95% Proyecto

**Objetivo:** Asegurar estabilidad y performance.

### Paso 6.1: Testing Local
- [ ] Unit Tests para `PromptManager`
- [ ] Unit Tests para cálculo de Streaks
- [ ] Integration Tests para DB

### Paso 6.2: Testing en Dispositivo Real
- [ ] Ciclo completo: crear tarea → completar → ver racha → bloquear app
- [ ] Pruebas de batería con AccessibilityService corriendo 8 horas
- [ ] Pruebas de memoria (no memory leaks)

### Paso 6.3: Optimizaciones
- [ ] Reducir tamaño del APK
- [ ] Comprimir imágenes
- [ ] Lazy loading en listas largas
- [ ] Proguard/R8 para release

**Entregable esperado:** App estable, sin crashes, consumo bajo de batería.

---

## 📦 Fase 7: DISTRIBUCIÓN (Semana 6) - 100% Proyecto

**Objetivo:** Tener el APK listo para compartir o publicar.

### Paso 7.1: Generación de APK
- [ ] Configurar `signing.properties` (firma de app)
- [ ] Build > Generate Signed Bundle/APK
- [ ] Guardar certificado (.jks) en lugar seguro

### Paso 7.2: Documentación de Usuario
- [ ] Crear guía de "Primeros pasos"
- [ ] Instrucciones para XOS (Infinix)
- [ ] FAQ de problemas comunes

### Paso 7.3: Opcionales
- [ ] Publicar en **Google Play Store** (requiere cuenta desarrollador: $25)
- [ ] Distribuir APK directamente a amigos
- [ ] Crear landing page / README con capturas

---

## 🗺️ Timeline Recomendado

| Fase | Tareas | Tiempo | Estado |
|------|--------|--------|--------|
| **Fase 0** | Investigación | ✅ Completado | ✅ HECHO |
| **Fase 1** | Setup & Android Studio | 2-3 horas | ⏳ PRÓXIMO |
| **Fase 2** | Frontend básico | 3-4 días | 📅 Esta semana |
| **Fase 3** | AI Coach | 3-4 días | 📅 Semana 2 |
| **Fase 4** | AccessibilityService | 4-5 días | 📅 Semana 3 |
| **Fase 5** | Gamificación | 2-3 días | 📅 Semana 4 |
| **Fase 6** | Testing | 2-3 días | 📅 Semana 5 |
| **Fase 7** | Distribución | 1-2 días | 📅 Semana 6 |

**Total estimado:** 6 semanas trabajando ~2-3 horas/día.

---

## 🚀 Tu Próximo Paso Inmediato

**Hoy/Mañana:** Instala Android Studio y completa la **Fase 1** (Setup).

1. Descarga [Android Studio](https://developer.android.com/studio)
2. Instala (siguiendo el wizard)
3. Clona el repositorio
4. Abre en Android Studio
5. Espera Gradle Sync
6. Avísame cuando veas el código compilado sin errores

¿Listo para empezar?
