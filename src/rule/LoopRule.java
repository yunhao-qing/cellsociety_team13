package rule;

import cell.Cell;
import simulation.Grid;

import java.util.List;

/**
 * @author Julia Saveliff
 */
public class LoopRule extends Rule {

    public LoopRule(Grid grid, List<Double> extraParameters) {
        super(grid, extraParameters);
    }

    @Override
    public void determineNextStates() {
        for (int i = 0; i < this.getGrid().getNumRow(); i++) {
            for (int j = 0; j < this.getGrid().getNumCol(); j++) {
                Cell C = this.getGrid().item(i, j);
                List<Cell> neighbors = this.getGrid().getDirectNeighbors(i, j);

                if (i == 0 || i == this.getGrid().getNumRow() - 1 || j == 0 || j == this.getGrid().getNumCol() - 1) {
                    C.setNextState(0);
                } else {
//                    int S = neighbors.get(0).getState();
//                    int N = neighbors.get(1).getState();
//                    int E = neighbors.get(2).getState();
//                    int W = neighbors.get(3).getState();
//
//                    // determine direction
//                    if (C.getState()==1) {
//                        if (S==4) {
//                            ((LoopCell) C).setDirection(LoopCell.LEFT);
//                        } else if (N==4) {
//                            ((LoopCell) C).setDirection(LoopCell.RIGHT);
//                        } else if (E==4) {
//                            ((LoopCell) C).setDirection(LoopCell.DOWN);
//                        } else if (W==4) {
//                            ((LoopCell) C).setDirection(LoopCell.UP);
//                        }
//                    }


                    int B = neighbors.get(0).getState();
                    int T = neighbors.get(1).getState();
                    int R = neighbors.get(2).getState();
                    int L = neighbors.get(3).getState();
//                    if (((LoopCell) C).getDirection()==LoopCell.DOWN) {
//                        T = neighbors.get(0).getState();
//                        B = neighbors.get(1).getState();
//                        L = neighbors.get(2).getState();
//                        R = neighbors.get(3).getState();
//                    } else if (((LoopCell) C).getDirection()==LoopCell.RIGHT) {
//                        R = neighbors.get(0).getState();
//                        L = neighbors.get(1).getState();
//                        T = neighbors.get(2).getState();
//                        B = neighbors.get(3).getState();
//                    } else if (((LoopCell) C).getDirection()==LoopCell.LEFT) {
//                        L = neighbors.get(0).getState();
//                        R = neighbors.get(1).getState();
//                        B = neighbors.get(2).getState();
//                        T = neighbors.get(3).getState();
//                    }

                    // if cell is 0
                    if (C.getState() == 0) {
                        C.setNextState(0);
                        if (T == 0 && R == 0) {
                            if (B == 0 && L== 3) {
                                C.setNextState(1);
                            } else if (B == 1) {
                                if (L == 2 || L == 5) {
                                    C.setNextState(2);
                                } else if (L == 3) {
                                    C.setNextState(1);
                                }
                            } else if (B == 2 && L == 5) {
                                C.setNextState(5);
                            } else if (B == 3) {
                                if (L == 1) {
                                    C.setNextState(5);
                                } else if (L == 2) {
                                    C.setNextState(3);
                                }
                            } else if (B == 4 && L == 2) {
                                C.setNextState(2);
                            }
                        } else if (T==2 && R==0 && B==0 && L==5) {
                            C.setNextState(5);
                        }
                    }

                    // if cell is 1
                    else if (C.getState() == 1) {
                        C.setNextState(4);
                        if (T == 0) {
                            if (R == 0) {
                                if (B == 0) {
                                    if (L == 0 || L == 1 || L == 4) {
                                        C.setNextState(0);
                                    } else if (L == 3) {
                                        C.setNextState(3);
                                    }
                                } else if (B == 3 && L== 3) {
                                    C.setNextState(0);
                                } else if (B == 4 && L == 3) {
                                    C.setNextState(1);
                                }
                            } else if (R == 3 && B == 2 && L == 1) {
                                C.setNextState(3);
                            }
                        } else if (B == 5 && L == 3) {
                            if (T == 1 && R == 2) {
                                C.setNextState(1);
                            } else if (T == 2 && R == 4) {
                                C.setNextState(3);
                            }
                        }
                    }

                    // if cell is 2
                    else if (C.getState() == 2) {
                        C.setNextState(2);
                        if (T == 0) {
                            if (R == 0) {
                                if ((B== 0 && L == 0) || (B == 2 && L == 2)) {
                                    C.setNextState(0);
                                } else if (B == 1 && L == 5) {
                                    C.setNextState(5);
                                }
                            } else if (R == 2) {
                                if (B == 0 && L == 2) {
                                    C.setNextState(0);
                                } else if ((B == 1 && L == 5) || (B == 5 && L == 2)) {
                                    C.setNextState(5);
                                } else if (B == 3 && L == 5) {
                                    C.setNextState(3);
                                }
                            }
                        }
                    }

                    // if cell is 3
                    else if (C.getState() == 3) {
                        C.setNextState(3);
                        if (T == 0) {
                            if (R == 0) {
                                if (B == 0 && (L == 1 || L == 3)) {
                                    C.setNextState(0);
                                } else if (B == 1) {
                                    if (L == 1) {
                                        C.setNextState(0);
                                    } else if (L == 2) {
                                        C.setNextState(1);
                                    }
                                }
                            } else if (R == 1 && B == 2 && (L == 1 || L == 3)) {
                                C.setNextState(1);
                            }
                        } else if (T == 1) {
                            if (R == 1) {
                                if (B == 2 && (L == 2 || L == 3)) {
                                    C.setNextState(1);
                                }
                            } else if (R == 2) {
                                if (B == 1 && L == 5) {
                                    C.setNextState(1);
                                } else if (B == 2 && L == 3) {
                                    C.setNextState(1);
                                } else if (B == 3 && (L== 3 || L == 5)) {
                                    C.setNextState(1);
                                }
                            } else if (R == 4) {
                                if (B == 3 && L == 2) {
                                    C.setNextState(1);
                                } else if (B == 5 && L == 2) {
                                    C.setNextState(5);
                                }
                            }
                        }

                        if (T==2 && R==1 && B==3 && L==2) {
                            C.setNextState(1);
                        } else if (T==1 && R==3 && B==2 && L==2) {
                            C.setNextState(1);
                        } else if (T==3 && R==2 && B==2 && L==1) {
                            C.setNextState(1);
                        } else if (T==2 && R==2 && B==1 && L==3) {
                            C.setNextState(1);
                        }

                    }

                    // if cell is 4
                    else if (C.getState() == 4) {
                        C.setNextState(3);
                        if (T == 0) {
                            if (R == 0) {
                                if (L == 3) {
                                    if (B == 0) {
                                        C.setNextState(5);
                                    } else if (B == 4) {
                                        C.setNextState(4);
                                    }
                                }
                            } else if (R== 2) {
                                if (L == 2) {
                                    if (B == 1 || B == 3 || B == 4) {
                                        C.setNextState(4);
                                    } else if (B == 5) {
                                        C.setNextState(0);
                                    }
                                }
                            } else if (R == 3 && B == 2 && L == 5) {
                                C.setNextState(5);
                            }
                        }
                    }

                    // if cell is 5
                    else if (C.getState() == 5) {
                        C.setNextState(2);
                        if (T == 0) {
                            if (R == 0 && L == 2 && (B == 2 || B == 3)) {
                                C.setNextState(5);
                            } else if (R == 2 && L == 2) {
                                if (B == 1) {
                                    C.setNextState(4);
                                } else if (B == 2) {
                                    C.setNextState(0);
                                }
                            } else if (R == 3 && B == 2 && L == 2) {
                                C.setNextState(0);
                            }
                        }
                    }

                }
            }
        }

    }

}
