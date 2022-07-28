export default function addAlbum() {
    return `

    <input type="text" class="albumTitle-input" placeholder="Album Title">                
    <p class ="title">Title Of Album</p>

    <input type="text" class="imgUrl-input" placeholder="Image Url">                
    <p class ="title">Image URL</p>

    <input type="text" class="recordLabel-input" placeholder="Record Label">                
    <p class ="title">Record Label</p>


    <input type="text" class="ratings-input" placeholder="Ratings">                
    <p class ="title">Ratings</p>

    <button class="add-button">Add Album</button>
    
    <a class="back-navigation">back to album listings</a>
    `

}