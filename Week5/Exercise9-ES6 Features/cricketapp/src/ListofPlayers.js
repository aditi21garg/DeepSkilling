export function ListofPlayers({ players }) {
    return (
        <div>
            {players.map((item) => {
                return (
                    <li>Mr. {item.name} <span> {item.score} </span></li>
                );
            })}
        </div>
    );
}