# 🎬 Gestor de Películas

Aplicación de escritorio desarrollada en Java con Swing que permite gestionar un catálogo de películas. Puedes agregar, editar, eliminar, buscar, ordenar y visualizar estadísticas básicas del catálogo.

---

## 🚀 ¿Cómo ejecutar la aplicación?

1. Descarga y descomprime el proyecto.
2. Abre **Eclipse IDE**.
3. Importa el proyecto:
   - Ve a `File > Open Projects from File System...`
   - Selecciona la carpeta donde descomprimiste el proyecto.
4. Busca la clase `AplMain.java` dentro del paquete principal.
5. Haz clic derecho sobre `AplMain.java` → `Run As > Java Application`.

---

## 🧪 ¿Cómo ejecutar las pruebas?

1. Ubica el paquete de pruebas:  
   `co.edu.unbosque.modelo` (o el que contiene tus clases de test).
2. Abre la clase `SuitePruebas.java`.
3. Haz clic derecho sobre `SuitePruebas.java` → `Run As > JUnit Test`.

Se ejecutarán todas las pruebas requeridas.

---

## 📊 Funcionalidades disponibles

- Agregar nuevas películas
- Editar información de películas existentes
- Eliminar películas
- Buscar por título o parte del nombre
- Filtrar por género
- Ordenar por fecha de estreno o calificación
- Ver estadísticas:
  - Número total de películas
  - Calificación promedio global
  - Duración total del catálogo (en horas)

---

## ✅ Requisitos

- Java 8 o superior
- Eclipse IDE con soporte para JUnit 5
- No requiere base de datos ni frameworks externos


## 📌 Nota

Este proyecto está diseñado con fines educativos y sigue una arquitectura en capas (modelo, vista, controlador), aplicando buenas prácticas de Java puro y pruebas unitarias con JUnit 5.

