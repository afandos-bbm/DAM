using System.Net.Mime;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
public class PlayerController : MonoBehaviour
{
    public float speed;//Fuerza lineal
    private Rigidbody rb;

    public int score = 0;
    public Text scoreText;
    public Text winText;
    // Start is called before the first frame update
    void Start()
    {
        //guardamos en la variable el componente RigidBody de la esfera
        rb = GetComponent<Rigidbody>();
        scoreText.text = "Score: " + score.ToString();
        winText.text = "";
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKey("escape"))
            Application.Quit();
    }
    // Make the player smaller if hits to the wall
    // Make the wall smaller if hits to the player
    void OnCollisionEnter(Collision other)
    {
        if (other.gameObject.CompareTag("Wall"))
        {
            if (transform.localScale.x >= 0.5f)
            {
                transform.localScale -= new Vector3(0.05f, 0.05f, 0.05f);
                if (other.gameObject.transform.localScale.y > 0.1f)
                {
                    other.gameObject.transform.localScale -= new Vector3(0, 0.5f, 0);
                }
                else
                {
                    other.gameObject.SetActive(false);
                }
            }
            else
            {
                winText.text = "You Lose!";
            }
        }
    }

    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("PickUp"))
        {
            // check if the color of the player is the same as the color of the pick up and if so, destroy the pick up
            if (GetComponent<Renderer>().material.color == other.gameObject.GetComponent<Renderer>().material.color)
            {
                other.gameObject.SetActive(false);
                Debug.Log("Score: " + score);
                score++;
                scoreText.text = "Score: " + score.ToString();
            }
            if (score >= 12)
            {
                winText.text = "You Win!";
            }
        }
    }
    void FixedUpdate()
    {
        float moveHorizontal = Input.GetAxis("Horizontal");
        float moveVertical = Input.GetAxis("Vertical");

        Vector3 movement = new Vector3(moveHorizontal, 0.0f, moveVertical);

        rb.AddForce(movement * speed);


        //Changes randomly the color of the player every 5 seconds
        if (Time.time % 5 == 0)
        {
            GetComponent<Renderer>().material.color = new Color(Random.Range(0f, 1f), Random.Range(0f, 1f), Random.Range(0f, 1f));
        }
    }
}
