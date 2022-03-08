using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Cinematico0 : MonoBehaviour
{
    public float speed;
       
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        //Movemos la esfera en funcion de las teclas a, d o flechas izda. y dcha. (eje X)
        //Movemos la esfera en funcion de las teclas w, s o flechas arriba y abajo (eje Z)
        //Aplicamos una velocidad de movimiento (speed) y lo pasamos a m/s
        transform.Translate(
                Input.GetAxis("Horizontal") * speed * Time.deltaTime,
                0,
                Input.GetAxis("Vertical") * speed * Time.deltaTime
        );
    }
}
