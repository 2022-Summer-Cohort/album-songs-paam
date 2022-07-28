export default function songView(song) {
    return `
    <h class="song-title">${song.title}</h>
    <h class="song-link">${song.link}</h>
    <h class="song-duration">${song.duration}</h>
    <input type="hidden" class="id_field" value="${song.id}">
    <br>

    <div class="addComment">
    <input type="text" placeholder="User Name" class="userNameInput" \>
    <input type="text" placeholder="Comment" class="commentInput" \>

    <button class="addCommentButton">Add Comment</button>
    </div>

    <br>
    <a class="back-navigation">back to album listings</a>
    <br>
    <a class="back-navigation-toSong">back to song listings</a>
    `
}