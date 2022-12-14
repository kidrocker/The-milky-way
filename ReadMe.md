# The Milky way

## Libraries used

1. Retrofit and gson - Data fetching from the api. The libraries provide a standard way to fetch, enqueue and parse json into objects.
2. Navigation components - The library simplifies navigation between fragments with animations and safe arguments. Navigation safe args allow us to share data between fragments safely.
3. Glide - Glide provides a simplified lazy loading of images from a network source.
4. Hilt - Dependency injection simplified. Hilt is preferred as it is simpler to implement than dagger yet as powerful

## What could be improved
1. Implementation of paging library to allow for silent loading of paginated data
2. Local data persistence using room database.

Gradle requires java 11 to run [check here](https://stackoverflow.com/questions/66980512/android-studio-error-android-gradle-plugin-requires-java-11-to-run-you-are-cur)