import React from 'react'
import { View, Text, TouchableOpacity } from 'react-native';
 
interface BotonProps {
   texto: string,
   color: string,
   ancho?: boolean
   accion: ( numeroTexto:string ) => void
}
 
function Boton({texto, color, ancho, accion}:BotonProps) {
 return (
    <TouchableOpacity onPress={() => accion(texto)}>
        <View style={{height:80, width: (ancho) ? 180 : 80, backgroundColor: color, borderRadius:100, justifyContent:'center', marginHorizontal: 10}}>
            <Text style={{color: ( color === "#9B9B9B") ? 'black' : 'white', textAlign:'center', fontSize:30}}>{texto}</Text>
        </View>
    </TouchableOpacity>
 )
}
 
export default Boton