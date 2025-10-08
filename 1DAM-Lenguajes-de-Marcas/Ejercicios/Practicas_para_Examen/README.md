## Diferentes Patterns (Regex) q pueden caer:
- Atributo codigo obligatorio (formato: PKT-XXXX) <xs:pattern value="PKT\-[0-9]{4}" />
- ID obligatorio: C + 3 digitos (0-9)
<xs:attribute name="id" use="required">
    <xs:simpleType>
        <xs:restriction base="xs:string">
            <xs:pattern value="C\d{3}"/>
        </xs:restriction>
    </xs:simpleType>
</xs:attribute>
- email: <xs:pattern value="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}"/>
- DNI: <xs:pattern value="[0-9]{8}[A-Za-z]{1}"></xs:pattern>
- Nota con decimales: <xs:pattern value="\d(\.\d)?"/>
- Nombre y Apellidos debe empezar en mayuscula: <xs:pattern value="[A-Z][a-z]+ [A-Z][a-z]+"/>
- string con regex: 3–15 caracteres alfanuméricos o guiones bajos: <xs:pattern value="[A-Za-z0-9_]{3,15}"/>
- precio (decimal, con 2 decimales exactos) <xs:pattern value= "\d+\.\d{2}">
- Atributo codigo obligatorio (formato: PKT-XXXX) <xs:pattern value="PKT\-[0-9]{4}" />