from automata.fa.dfa import DFA

dfa = DFA(
    states={'q0', 'q1', 'q2'},
    input_symbols={'0', '1'},
    transitions={
        'q0': {'0': 'q1', '1': 'q0'},
        'q1': {'0': 'q1', '1': 'q2'},
        'q2': {'0': 'q1', '1': 'q0'}
    },
    initial_state='q0',
    final_states={'q2'}
)

tests = ['101', '1101', '100', '01', '111', '0001']

for s in tests:
    if dfa.accepts_input(s):
        print(s, "Accepted")
    else:
        print(s, "Rejected")