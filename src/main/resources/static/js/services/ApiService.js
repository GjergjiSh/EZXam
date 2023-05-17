class ApiService {

    static async getRequest(path) {
        try {
            return await fetch('http://localhost:8080/' + path)
                .then(response => response.json())
        } catch (e) {
            console.log("Error while getting: " + path)
            throw new Error(e)
        }
    }
}