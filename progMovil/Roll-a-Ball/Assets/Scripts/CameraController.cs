using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraController : MonoBehaviour
{
    public GameObject jugador; //Variable para reverenciar nuestro jugador
    private Vector3 offset; //Variable para registrar la diferencia entre la posición de la cámara y la del jugador

    void Start()
    {
        //Get the palyer
        jugador = GameObject.FindGameObjectWithTag("Player");
        //Diferencia entre la posición de la cámara y la del jugador
        offset = transform.position - jugador.transform.position;
    }

    void LateUpdate()
    {
        transform.position = jugador.transform.position + offset;
    }

}
