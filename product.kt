package productDisplayBackend

class Product {
	var id: String? = null
	var name: String? = null
	var category: String? = null
 
	constructor() {}
	constructor(id: String?, name: String?, category: String?) {
		this.id = id
		this.name = name
		this.category = category
	}

	fun toJSON() {
        val json = JSONObject()
        json.put("id", this.id)
        json.put("name", this.name)
        json.put("category", this.category)

        return json
    }
	
}