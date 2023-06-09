class ApiService {

  static async getRequest(path) {
    try {
      const response = await fetch(`http://localhost:8080/${path}`);
      return response;
    } catch (e) {
      console.log(`Error while getting: ${path}`);
      throw new Error(e);
    }
  }

  static async postRequest(path, contentJSON) {
    try {
      const response = await fetch(`http://localhost:8080/${path}`, {
        method: "POST",
        body: JSON.stringify(contentJSON),
        headers: {
          "Content-Type": "application/json; charset=UTF-8"
        }
      });
      return response;
    } catch (e) {
      console.log(`Error while posting: ${path}`);
      throw new Error(e);
    }
  }

  static async putRequest(path, contentJSON) {
    try {
      const response = await fetch(`http://localhost:8080/${path}`, {
        method: "PUT",
        body: JSON.stringify(contentJSON),
        headers: {
          "Content-Type": "application/json; charset=UTF-8"
        }
      });
      return response;
    } catch (e) {
      console.log(`Error while putting: ${path}`);
      throw new Error(e);
    }
  }

    static async deleteRequest(path) {
      try {
        const response = await fetch(`http://localhost:8080/${path}`, {
          method: "DELETE"
        });
        return response;
      } catch (e) {
        console.log(`Error while deleting: ${path}`);
        throw new Error(e);
      }
    }
}
