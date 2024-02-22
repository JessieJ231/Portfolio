using UnityEngine;
using System.Collections;
/**SpawnGameObjects
 * Randomly spawn game objects to the world.
 * - Randomly select object from a list of objects (you need to set up) to spawn;
 * - Spawn to a random position (you need to set up the range and the center object)
 * 
 * To use it:
 * 1. Create an empty object as spawner
 * 2. Attached the script to the spawner object
 * 3. Configure the range, center object if you have, and the prefab objects. 
 *    Note that the object to spawn is randomly selected from the array so if you want one object to be spawned more often than the other, simply put more of that object in the array
 * 
 *** Note that the spawning is just to "make it alive", or "bring it to the world".
 *** The behavior AFTER spawning should be configured for each of the prefabricated object. *** 
 * */
public class SpawnGameObjects : MonoBehaviour
{
	// public variables
	public float secondsBetweenSpawning = 0.1f;
	public float xMinRange = -25.0f;
	public float xMaxRange = 25.0f;
	public float yMinRange = 8.0f;
	public float yMaxRange = 25.0f;
	public float zMinRange = -25.0f;
	public float zMaxRange = 25.0f;
	public Transform CenterObject;

	public GameObject[] spawnObjects; // what prefabs to spawn

	private float nextSpawnTime;

	// Use this for initialization
	void Start ()
	{
		// determine when to spawn the next object
		nextSpawnTime = Time.time+secondsBetweenSpawning;
	}
	
	// Update is called once per frame
	void Update ()
	{
		// exit if there is a game manager and the game is over
        /*
		if (GameManager.gm) {
			if (GameManager.gm.gameIsOver)
				return;
		}
        */
		// if time to spawn a new game object
		if (Time.time  >= nextSpawnTime) {
			// Spawn the game object through function below
			MakeThingToSpawn ();

			// determine the next time to spawn the object
			nextSpawnTime = Time.time+secondsBetweenSpawning;
		}	
	}

	void MakeThingToSpawn ()
	{
		Vector3 spawnPosition;
        if (CenterObject)
        {
            spawnPosition.x = CenterObject.transform.position.x + Random.Range(xMinRange, xMaxRange);
            spawnPosition.y = CenterObject.transform.position.y + Random.Range(yMinRange, yMaxRange);
            spawnPosition.z = CenterObject.transform.position.z + Random.Range(zMinRange, zMaxRange);
        }
        else //center object is not set, use the world origin
        {
            // get a random position between the specified ranges
            spawnPosition.x = Random.Range(xMinRange, xMaxRange);
            spawnPosition.y = Random.Range(yMinRange, yMaxRange);
            spawnPosition.z = Random.Range(zMinRange, zMaxRange);
        }
		// determine which object to spawn
		int objectToSpawn = Random.Range (0, spawnObjects.Length);

		// actually spawn the game object
		GameObject spawnedObject = Instantiate (spawnObjects [objectToSpawn], spawnPosition, transform.rotation) as GameObject;

		// make the parent the spawner so hierarchy doesn't get super messy
		spawnedObject.transform.parent = gameObject.transform;

	}
}
