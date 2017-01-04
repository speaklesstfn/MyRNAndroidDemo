import React, {Component} from 'react';
import {AppRegistry, StyleSheet, View, Text, TouchableHighlight, NativeModules,} from 'react-native';

export default class HelloWorld extends Component {
    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.text}>这是RN界面</Text>

                <TouchableHighlight style={styles.button} onPress={this.onButtonClick.bind(this)}>
                    <Text style={styles.buttonText}>点击弹自定义Toast</Text>
                </TouchableHighlight>
            </View>
        );
    }

    onButtonClick() {
        NativeModules.MyToast.showMyToast('dsddd');
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    text: {
        fontSize: 20,
        textAlign: 'center',
    },
    button: {
        marginTop: 35,
        justifyContent: 'center',
        alignItems: 'center',
        height: 30,
        marginHorizontal: 20,
        backgroundColor: '#48BBEC',
        borderRadius: 5,
        borderWidth: 1,
        borderColor: '#48BBEC',
    },
    buttonText: {
        fontSize: 18,
        textAlign: 'center',
    },
});

AppRegistry.registerComponent('firstrnandroiddemo', () => HelloWorld);