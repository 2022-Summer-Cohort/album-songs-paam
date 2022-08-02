export default function addAlbum() {
    return `
    <div class="addAlbum">
        <input type="text" class="albumTitle-input" placeholder="Album Title">                
        <br>
        <br>
        <input type="text" class="imgUrl-input" placeholder="Image Url">                
        <br>
        <br>
        <input type="text" class="recordLabel-input" placeholder="Record Label">                
        <br>
        <br>
        <input type="text" class="ratings-input" placeholder="Ratings">                
        <br>
        <br>
        <button class="add-button">Add Album</button>
        <br>
        <br>
        <a class="back-navigation">back to album listings</a>
    </div> 
    `

}