package productDisplayBackend

class Part {
	var punctuatedPartNumber: Int? = 0
	var description: String? = null
	var id: String? = null
	var originalRetailPrice: Float? = 0.0
	var brandName: String? = null
	var imageURL: String? = null
 
	constructor() {}
	constructor(punctuatedPartNumber: Int?, description: String?, id: String?, originalRetailPrice: Float?,
				brandName: String?, imageURL: String?) {
		this.punctuatedPartNumber = punctuatedPartNumber
		this.description = description
		this.id = id
		this.originalRetailPrice = originalRetailPrice
		this.brandName = brandName
		this.imageURL = imageURL
	}

	fun toJSON() {
		val json = JSONObject()
		json.put("id", this.id)
		json.put("brand name", this.brandName)
        json.put("punctuated part number", this.punctuatedPartNumber)
        json.put("image URL", this.imageURL)
        json.put("description", this.description)
        json.put("original retail price", this.originalRetailPrice)
	}
	
}