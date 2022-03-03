using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NewBehaviourScript1 : MonoBehaviour
{
    public string[] array1 = new string[10];
    public string[] array2 = new string[10];

    void Start() {
        array1[0] = "Uno";
        array1[1] = "Dos";
        array1[2] = "Tres";
        array1[3] = "Cuatro";
        array1[4] = "Cinco";
        array1[5] = "Seis";
        array1[6] = "Siete";
        array1[7] = "Ocho";
        array1[8] = "Nueve";
        array1[9] = "Diez";

        for (int i = 0; i < array2.Length; i++) {
            array2[i] = array1[array1.Length - i - 1];
        }
        for (int i = 0; i < array2.Length; i++) {
            Debug.Log(array2[i]);
        }
    }
    void Update()
    {

    }
}

