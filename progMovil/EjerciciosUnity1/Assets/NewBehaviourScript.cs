using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NewBehaviourScript : MonoBehaviour
{
    public int valorCompra;
    public int valorPago;

    void Start()
    {
        int cambio;
        int cambioInicial;
        int moneda100 = 0;
        int moneda50 = 0;
        int moneda20 = 0;
        int moneda10 = 0;
        int moneda5 = 0;
        int moneda2 = 0;
        int moneda1 = 0;

        if (valorCompra < valorPago)
        {

            cambioInicial = valorPago - valorCompra;
            cambio = cambioInicial;

            while (cambio > 0)
            {
                if (cambio >= 100)
                {
                    moneda100++;
                    cambio -= 100;
                }
                else if (cambio >= 50)
                {
                    moneda50++;
                    cambio -= 50;
                }
                else if (cambio >= 20)
                {
                    moneda20++;
                    cambio -= 20;
                }
                else if (cambio >= 10)
                {
                    moneda10++;
                    cambio -= 10;
                }
                else if (cambio >= 5)
                {
                    moneda5--;
                    cambio -= 5;
                }
                else if (cambio >= 2)
                {
                    moneda2--;
                    cambio -= 2;
                }
                else if (cambio >= 1)
                {
                    moneda1--;
                    cambio -= 1;
                }
            }


            Debug.Log("El cambio pendiente es de " + cambioInicial + ". Se ha devuelto monedas de 100: " + moneda100 + " | monedas de 50: "
                + moneda50 + " | monedas de 20: " + moneda20 + " | monedas de 10: " + moneda20 + " | monedas de 5: "
                + moneda5 + " | monedas de 2: " + moneda2 + " | monedas de 1: " + moneda1);
        }
        else
        {
            Debug.Log("El valor de la compra es superior al valor del pago. No se puede realizar el cambio.");
        }
    }

    void Update()
    {

    }
}