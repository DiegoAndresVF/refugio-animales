```markdown
# 🐾 Refugio de Animales - Sistema de Gestión

## 📋 Descripción del Proyecto

**Refugio de Animales** es una aplicación de consola en Java diseñada para gestionar un refugio de animales. Permite registrar animales y sus especies, marcar adopciones, y generar reportes sobre el estado de los animales en el refugio.

El sistema permite:
- Registrar nuevos animales con su especie
- Agregar nuevas especies al catálogo
- Marcar animales como adoptados
- Consultar animales disponibles para adopción
- Ver reportes generales con estadísticas

## 🏗️ Estructura de Datos Usada

### **Colecciones Java utilizadas:**

| Colección | Variable | Propósito |
|-----------|----------|-----------|
| `List<String>` | `animales` | Almacena los nombres únicos de los animales registrados |
| `Map<String, String>` | `estadoAnimal` | Relaciona cada animal con su estado (`Disponible`/`Adoptado`) |
| `Set<String>` | `especies` | Conjunto de especies permitidas (sin duplicados) |
| `Map<String, String>` | `animalEspecie` | Relaciona cada animal con su especie |
| `Set<String>` | `animalesUnicos` | Controla que no se registren animales duplicados |

### **Arrays:**
- `String[] estados`: Contiene los posibles estados de un animal: `["Disponible", "Adoptado"]`

### **Variables estáticas:**
- `Scanner sc`: Para lectura de entrada del usuario
- Todas las colecciones son `static` para persistencia durante la ejecución

## 🚀 Cómo Ejecutar el Programa

### **Requisitos:**
- Java JDK 11 o superior
- Terminal o línea de comandos

### **Pasos de ejecución:**

1. **Compilar el programa:**
```bash
javac RefugioAnimales.java
```

2. **Ejecutar el programa:**
```bash
java RefugioAnimales
```

## 📱 Ejemplo de Menú

```
=== REFUGIO DE ANIMALES ===
1. Registrar animal
2. Registrar especie
3. Marcar animal como adoptado
4. Mostrar animales disponibles
5. Mostrar animales adoptados
6. Mostrar reporte general
7. Salir
Ingrese opción: 
```

### **Flujo de uso típico:**

1. **Primero registrar especies** (opción 2)
   ```
   Ingrese la especie a registrar: hámster
   ```

2. **Registrar animales** (opción 1)
   ```
   Ingrese el nombre del animal: Pelusa
   Ingrese la especie: gato
   ```

3. **Consultar animales disponibles** (opción 4)
   ```
   Pelusa=Disponible
   ```

4. **Marcar adopción** (opción 3)
   ```
   Pelusa → gato
   Ingrese animal a adoptar: Pelusa
   ```

5. **Ver reporte general** (opción 6)
   ```
   --------------------------------------
              Reporte general       
   --------------------------------------
   | Nombre    | Especie | Estado     |
   --------------------------------------
   | Pelusa    | gato    | Adoptado   |
   --------------------------------------
   ```

## 🔧 Funcionalidades Detalladas

### **1. Registrar Animal**
- Valida que el nombre no esté duplicado
- Verifica que la especie exista en el sistema
- Asigna estado inicial "Disponible"

### **2. Registrar Especie**
- Agrega nuevas especies al catálogo
- Convierte automáticamente a minúsculas

### **3. Adoptar Animal**
- Muestra lista de animales con sus especies
- Cambia estado de "Disponible" a "Adoptado"
- Usa `entrySet()` para recorrer y modificar el Map

### **4. Mostrar Disponibles**
- Usa Streams API con `filter()` y `forEach()`
- Filtra animales con estado "Disponible"

### **5. Mostrar Adoptados**
- Similar a disponibles pero filtra por "Adoptado"

### **6. Reporte General**
- Muestra estadísticas totales
- Presenta tabla formateada con `printf()`
- Alinea columnas con formato `%-10s`, `%-8s`

## 💡 Características Técnicas

- **Uso de Streams API** para filtrado y conteo
- **Validación de duplicados** con `HashSet`
- **Formato de tabla profesional** con `System.out.printf()`
- **Manejo de mayúsculas/minúsculas** consistente
- **Menú interactivo** con `do-while` y `switch` moderno

## ⚠️ Consideraciones

- Los datos se pierden al cerrar el programa (no hay persistencia)
- Los nombres de animales son case-sensitive
- Especies se almacenan en minúsculas automáticamente
- Diseñado para fines educativos de manejo de colecciones

---

**Nota:** Este proyecto fue desarrollado para practicar el uso de colecciones Java (List, Map, Set) y estructuras de control en aplicaciones de consola.

**Versión:** 1.0 | **Tecnología:** Java Collections Framework
```

Este README.md incluye:
1. ✅ Descripción clara del proyecto
2. ✅ Explicación detallada de la estructura de datos
3. ✅ Instrucciones claras de ejecución
4. ✅ Ejemplo completo del menú y flujo de uso
5. ✅ Formato markdown profesional con tablas y código
6. ✅ Características técnicas y consideraciones importantes