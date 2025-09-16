# 💼 Billetera Virtual - AlfiWallet

> Una aplicación de consola en Java que simula una billetera virtual con funciones básicas de gestión financiera: consultar saldo, depositar, retirar, convertir moneda y ver historial de transacciones.


## 🧑‍💻 Autor

**Mauricio Vera**


## 📌 Descripción del Proyecto

Este proyecto implementa una **billetera virtual interactiva por consola**, donde el usuario puede:

- Iniciar sesión con su **nombre y contraseña segura**.
- Realizar operaciones como:
  - ✅ Consultar saldo actual.
  - 💰 Depositar dinero.
  - 💸 Retirar dinero.
  - 💱 Convertir entre USD y EUR.
  - 📜 Ver historial de transacciones.
- Cerrar sesión de forma segura.

Incluye **validaciones de entrada** para garantizar la seguridad y la integridad de los datos ingresados.


## 🔐 Requisitos de Contraseña

La contraseña debe cumplir con los siguientes criterios (expresión regular):

```
^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^A-Za-z0-9]).{8,}$
```

Es decir:
- Al menos **una letra mayúscula**.
- Al menos **una letra minúscula**.
- Al menos **un dígito numérico**.
- Al menos **un carácter especial**.
- Mínimo **8 caracteres de longitud**.

> ⚠️ El usuario tiene **4 intentos** para ingresar la contraseña correctamente. Si falla, se bloquea el acceso.


## 📋 Validación de Nombre

El nombre del usuario solo puede contener **letras** (incluyendo vocales acentuadas y la letra "ñ").

Patrón permitido:
```
^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$
```


## 🧩 Estructura del Menú

Una vez iniciada la sesión, el usuario accede al siguiente menú:

```
 0: Salir
 1: Consultar saldo
 2: Depositar
 3: Retirar
 4: Convertir moneda (USD/EUR o EUR/USD)
 5: Obtener transacciones
```


## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Java 17+ (compatible con versiones anteriores)
- **Clases principales**:
  - `BilleteraVirtual.java` (clase principal con el menú interactivo)
  - `AlfiWallet.java` (lógica de la billetera: saldo, transacciones, conversión)
  - `Usuario.java` (modelo de usuario con nombre, ID y billetera asociada)
- **Estructuras de datos**: `ArrayList<Usuario>` para almacenar usuarios (simulación de base de datos).
- **Entrada/Salida**: `Scanner` para interacción por consola.
- **Validaciones**: Expresiones regulares para nombre y contraseña.


## ▶️ Cómo Ejecutar el Proyecto

1. **Clonar o descargar el proyecto**.
2. **Compilar**:
   ```bash
   javac com/mycompany/billeteravirtual/BilleteraVirtual.java
   ```
3. **Ejecutar**:
   ```bash
   java com.mycompany.billeteravirtual.BilleteraVirtual
   ```
4. Sigue las instrucciones en pantalla.


## 📸 Ejemplo de Uso

```
*********************  
* Billetera Virtual *  
*********************  

Ingrese su nombre:  
Mauricio

Ingrese la clave de su cuenta...  
Clave123!

******************  
Ingrese una opcion  
 0: Salir  
 1: Consultar saldo  
 2: Depositar  
 3: Retirar  
 4: Convertir moneda (EUR/USD)  
 5: Obtener transacciones  
**************************

1

Mauricio. Su saldo es: $0
```


## 📈 Características Futuras (Sugeridas)

- ✅ Persistencia de datos (archivos o base de datos).
- 👥 Soporte para múltiples usuarios con login real.
- 📊 Interfaz gráfica (JavaFX o Swing).
- 🌐 Soporte para más monedas (JPY, GBP, etc.).
- 🔔 Notificaciones por correo o SMS.
- 📲 Integración con API de conversión de divisas en tiempo real.


## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.  
¡Siéntete libre de usarlo, modificarlo y aprender con él!


## 🙌 Agradecimientos

Gracias por utilizar **AlfiWallet**.  
¡Esperamos que disfrutes gestionando tu dinero de forma virtual y segura!


> 💡 *¿Encontraste un error o tienes una sugerencia? ¡Abre un issue o envía un pull request!*
