import React, { useState } from 'react'
import { View, Text } from 'react-native';
import Boton from '../components/Boton';
import { styles } from '../themes/estilos';

enum Operadores {
    sumar, restar, multiplicar, dividir, none
 }
 
 
const CalculadoraScreen = () => {

    const [numero, setNumero] = useState('0')
    const [numeroAnterior, setNumeroAnterior] = useState('0')
    const [operacion, setOperacion] = useState<Operadores>(Operadores.none)
  
    const limpiar = () => {
        setNumero('0');
        setNumeroAnterior('0');
    }
  
    const setSigno = () => {
        if (numero.includes('-')){
            setNumero(numero.replace('-',''))
        }else {
            setNumero('-'+numero)
        }
    }

    const armarNumero = ( numeroTexto: string) => {
        // No aceptar doble punto
        if( numero.includes('.') && numeroTexto === '.' ) return;
  
        if ( numero.startsWith('0') || numero.startsWith('-0') ) {
  
            // Punto decimal
            if ( numeroTexto === '.' ) {
                setNumero( numero + numeroTexto );
  
                // Evaluar si es otro cero, y hay un punto
            } else if( numeroTexto === '0' && numero.includes('.')  ) {
                setNumero( numero + numeroTexto );
  
                // Evaluar si es diferente de cero y no tiene un punto
            } else if( numeroTexto !== '0' && !numero.includes('.') ) {
                setNumero( numeroTexto );
  
                // Evitar 0000.0
            } else if( numeroTexto === '0' && !numero.includes('.') ) {
                setNumero( numero );
            } else {
                setNumero( numero + numeroTexto );
            }
  
        } else {
            setNumero( numero + numeroTexto );
        }
    }

    const btnDelete = () => {
        let negativo = '';
        let numeroTemp = numero;
        if ( numero.includes('-') ) {
            negativo = '-';
            numeroTemp = numero.substr(1);
        }
  
        if ( numeroTemp.length > 1 ) {
            setNumero( negativo + numeroTemp.slice(0,-1) );
        } else {
            setNumero('0');
        }
    }
  
    const CambiarNumeroAnterior = () => {
        if (numero.endsWith('.')) {
            setNumeroAnterior(numero.slice(0,-1))
        }else {
            setNumeroAnterior(numero)
        }
        setNumero('0')
    }
  
    const btnDividir = () => {
        CambiarNumeroAnterior();
        setOperacion(Operadores.dividir)
    }
    const btnMultiplicar = () => {
        CambiarNumeroAnterior();
        setOperacion(Operadores.multiplicar)
    }
    const btnSumar = () => {
        CambiarNumeroAnterior();
        setOperacion(Operadores.sumar)
    }
    const btnRestar = () => {
        CambiarNumeroAnterior();
        setOperacion(Operadores.restar)
    }

    const calcular =() => {
        const num1 = Number(numero);
        const num2 = Number(numeroAnterior)
        switch(operacion){
            case Operadores.sumar:
                setNumero(`${num1 + num2} `)
                break;
            case Operadores.restar:
                setNumero(`${num2 - num1} `)
                break;
            case Operadores.multiplicar:
                setNumero(`${num1 * num2} `)
                break;
            case Operadores.dividir:
                setNumero(`${num2 / num1} `)
                break;
        }
        setNumeroAnterior('0')
    }
 
 
 

 return (
   <View style={styles.container}>
       {
           ( numeroAnterior !== '0') &&
           (<Text style={styles.resultadoPequeno}>{numeroAnterior}</Text>)
       }
       <Text style={styles.resultado}>{numero}</Text>
       <Text style={styles.resultado}>Momis</Text>
       <View style={styles.fila}>
            <Boton texto='AC' color='#9B9B9B' accion={limpiar}   />
            <Boton texto='+/-' color='#9B9B9B' accion={setSigno}/>
            <Boton texto='del' color='#9B9B9B' accion={btnDelete}/>
            <Boton texto='/' color='#FF9427' accion={btnDividir}/>
       </View>
       <View style={styles.fila}>
            <Boton texto='7' color='#2D2D2D' accion={armarNumero}/>
            <Boton texto='8' color='#2D2D2D' accion={armarNumero}/>
            <Boton texto='9' color='#2D2D2D' accion={armarNumero}/>
            <Boton texto='X' color='#FF9427' accion={btnMultiplicar}/>
       </View>
       <View style={styles.fila}>
            <Boton texto='4' color='#2D2D2D' accion={armarNumero}/>
            <Boton texto='5' color='#2D2D2D' accion={armarNumero}/>
            <Boton texto='6' color='#2D2D2D' accion={armarNumero}/>
            <Boton texto='-' color='#FF9427' accion={btnRestar}/>
       </View>
       <View style={styles.fila}>
            <Boton texto='1' color='#2D2D2D' accion={armarNumero}/>
            <Boton texto='2' color='#2D2D2D' accion={armarNumero}/>
            <Boton texto='3' color='#2D2D2D' accion={armarNumero}/>
            <Boton texto='+' color='#FF9427' accion={btnSumar}/>
       </View>
       <View style={styles.fila}>
            <Boton texto='0' color='#2D2D2D' ancho accion={armarNumero}/>
            <Boton texto='.' color='#2D2D2D' accion={armarNumero}/>
            <Boton texto='=' color='#FF9427' accion={calcular}/>            
       </View>       
   </View>
 )
}
 
export default CalculadoraScreen