export function ListofIndianPlayers({ IndianPlayers }) {
    return (
        <div>
            {IndianPlayers.map((item) => {
                return (
                    <li>Mr. {item}</li>
                );
            })}
        </div>
    );
}