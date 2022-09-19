import { StatusBar } from 'expo-status-bar';
import { Text, View } from 'react-native';
import { styles } from './src/themes/estilos';
import CalculadoraScreen from './src/screens/CalculadoraScreen';



export default function App() {
  return (
    <View style={styles.fondo}>
     <CalculadoraScreen/>
    </View>
  );
}
