# 🔧 Opciones para visualizar el XML en el HTML

A continuación se proponen **dos formas opcionales** para que visualices el XML directamente desde el navegador dentro de tu página web. Puedes elegir una o probar ambas.

---

## 🟢 Opción 2: Mostrar el XML dentro del HTML con un iframe

Esta es la forma más sencilla. Permite **visualizar el contenido del XML sin modificarlo**, directamente embebido en la página HTML.

### Ejemplo:
```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Visualización del XML</title>
</head>
<body>
  <h1>Catálogo y Proveedores (desde XML)</h1>

  <!-- Muestra el contenido del XML directamente -->
  <iframe src="instrumentos.xml" width="100%" height="500px"></iframe>

</body>
</html>
```

📌 **Qué hace:**
- Muestra el contenido del XML tal como lo interpreta el navegador.  
- No transforma los datos ni los presenta con estilo.  
- Es útil para comprobar rápidamente que el XML está bien formado.

---

## 🟣 Opción 3: Transformar el XML en HTML mediante XSLT

Esta opción permite **dar formato al XML directamente**, convirtiéndolo en una página HTML sin necesidad de JavaScript.  
Para ello necesitas dos archivos: el XML enlazado con XSL y la hoja XSLT.

### Ejemplo de `instrumentos.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="instrumentos.xsl"?>
<tienda>
  <catalogo>
    <instrumento id="INS-001" categoria="cuerda">
      <nombre>Guitarra clásica</nombre>
      <marca>Alhambra</marca>
      <precio>329.90</precio>
    </instrumento>
    <instrumento id="INS-002" categoria="viento">
      <nombre>Flauta travesera</nombre>
      <marca>Yamaha</marca>
      <precio>499.00</precio>
    </instrumento>
  </catalogo>
</tienda>
```

### Ejemplo de `instrumentos.xsl`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
      <head>
        <meta charset="UTF-8"/>
        <title>Catálogo de Instrumentos</title>
      </head>
      <body>
        <h1>Catálogo de Instrumentos</h1>
        <table border="1">
          <tr>
            <th>Nombre</th>
            <th>Marca</th>
            <th>Precio (€)</th>
          </tr>
          <xsl:for-each select="tienda/catalogo/instrumento">
            <tr>
              <td><xsl:value-of select="nombre"/></td>
              <td><xsl:value-of select="marca"/></td>
              <td><xsl:value-of select="precio"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
```

📌 **Qué hace:**
- Cuando abres el XML en el navegador, este aplica automáticamente la hoja XSL y lo muestra como una página HTML formateada.
- Permite dar estilo y estructura al XML de forma visual sin escribir código HTML por separado.
