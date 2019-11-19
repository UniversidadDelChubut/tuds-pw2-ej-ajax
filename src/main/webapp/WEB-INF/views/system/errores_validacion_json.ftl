{
<#list errores as key, value>
    "${key}": "${value?no_esc}"<#sep>,</#sep>
</#list>
}